package case4.repository;

import case4.model.dto.ShowCategory;
import case4.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepo extends JpaRepository<Category, Long> {

    @Query(nativeQuery = true, value = "select id, name from categories where user_id = ?;")
    Iterable<ShowCategory> getAllCategoryByUserId(Long user_id);

//    @Query(nativeQuery = true, value = "insert into categories(name, user_id) values ('?',?);")
//    void createCategory(Category category, Long user_id);
}
