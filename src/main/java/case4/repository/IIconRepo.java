package case4.repository;

import case4.model.entity.Icon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIconRepo extends JpaRepository<Icon, Long> {
}
