package com.aubay.spaceships;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.aubay.spaceships.application.command.getspaceship.GetSpaceship;
import com.aubay.spaceships.application.command.getspaceship.GetSpaceshipContainingNameRequest;
import com.aubay.spaceships.application.command.getspaceship.GetSpaceshipRequest;
import com.aubay.spaceships.application.command.getspaceship.GetSpaceshipResponse;
import com.aubay.spaceships.application.command.getspaceship.GetSpaceshipsRequest;
import com.aubay.spaceships.application.command.getspaceship.GetSpaceshipsResponse;
import com.aubay.spaceships.domain.Spaceship;
import com.aubay.spaceships.domain.SpaceshipRepositoryInterface;

@SpringBootTest
public class GetSpaceshipTest {

    @MockBean
    private SpaceshipRepositoryInterface spaceshipRepository;

    @Test
    public void testGetSpaceshipById() {
    	
        long spaceshipId = 1L;
        Spaceship expectedSpaceship = new Spaceship(spaceshipId, "Millennium Falcon", "mock spaceship");
        Optional<Spaceship> expectedOptionalSpaceship = Optional.of(expectedSpaceship);
        GetSpaceshipRequest request = new GetSpaceshipRequest(spaceshipId);

        Mockito.when(spaceshipRepository.findById(spaceshipId)).thenReturn(expectedOptionalSpaceship);

        GetSpaceship getSpaceship = new GetSpaceship(spaceshipRepository);

        GetSpaceshipResponse actualSpaceship = getSpaceship.handle(request);

        assertEquals(expectedSpaceship.getId(), actualSpaceship.getId());
    }
    
    @Test
    public void testGetSpaceshipsContainingName() {
        List<Spaceship> mockSpaceships = List.of(
            new Spaceship(1L, "Falcon Heavy", "Mock spaceship"),
            new Spaceship(2L, "Falcon 9", "Mock spaceship"),
            new Spaceship(3L, "Dragon", "Mock spaceship"),
            new Spaceship(4L, "Starship", "Mock spaceship")
        );

        Mockito.when(spaceshipRepository.findByNameContaining(ArgumentMatchers.anyString()))
               .thenAnswer(invocation -> {
                   String name = invocation.getArgument(0);
                   return mockSpaceships.stream()
                                        .filter(spaceship -> spaceship.getName().contains(name))
                                        .collect(Collectors.toList());
               });

        GetSpaceship getSpaceship = new GetSpaceship(spaceshipRepository);
        
        String partialName = "Falcon";
        GetSpaceshipContainingNameRequest request = new GetSpaceshipContainingNameRequest(partialName);

        GetSpaceshipsResponse actualSpaceships = getSpaceship.handleByName(request);

        assertEquals(2, actualSpaceships.getSpaceshipList().size());
        assertTrue(actualSpaceships.getSpaceshipList().stream().allMatch(spaceship -> spaceship.getName().contains(partialName)));
    }

    @Test
    public void testGetSpaceshipsCorrectPagination() {
        
    	List<Spaceship> mockSpaceships = List.of(mock(Spaceship.class), mock(Spaceship.class), mock(Spaceship.class), mock(Spaceship.class));
        Mockito.when(spaceshipRepository.findAll(ArgumentMatchers.any(Pageable.class)))
        .thenAnswer(invocation -> {
            Pageable pageable = invocation.getArgument(0);
            int pageSize = pageable.getPageSize();
            int pageNumber = pageable.getPageNumber();
            int fromIndex = pageSize * pageNumber;
            int toIndex = Math.min(fromIndex + pageSize, mockSpaceships.size());
            return new PageImpl<>(mockSpaceships.subList(fromIndex, toIndex), pageable, mockSpaceships.size());
        });	

        GetSpaceship getSpaceship = new GetSpaceship(spaceshipRepository);
        GetSpaceshipsRequest getSpaceshipsRequest = new GetSpaceshipsRequest(0, 2);
        Page<Spaceship> actualSpaceships = getSpaceship.handle(getSpaceshipsRequest);
        
        assertEquals(2, actualSpaceships.getNumberOfElements());
        
        getSpaceshipsRequest = new GetSpaceshipsRequest(0, mockSpaceships.size());
        actualSpaceships = getSpaceship.handle(getSpaceshipsRequest);
        
        assertEquals(mockSpaceships.size(), actualSpaceships.getNumberOfElements());
    }

}
