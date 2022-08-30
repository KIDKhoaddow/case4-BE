package case4.repository;

import case4.model.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepo extends JpaRepository<Blog,Long> {
}
