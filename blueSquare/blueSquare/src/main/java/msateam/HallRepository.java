package msateam;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="halls", path="halls")
public interface HallRepository extends PagingAndSortingRepository<Hall, Long>{


}
