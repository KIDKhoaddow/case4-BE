package com.case4.service.category;

import com.case4.model.dto.ShowCategory;
import com.case4.model.entity.classify.Category;
import com.case4.service.IGeneralService;

public interface ICategorySV extends IGeneralService<Category> {

    Iterable<ShowCategory> getAllCategoryByUserId(Long user_id);

}
