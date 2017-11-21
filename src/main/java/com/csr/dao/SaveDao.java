package com.csr.dao;

import com.csr.entity.Category;
import com.csr.entity.Charity;

public interface SaveDao {

	public void saveNgoDetails(Charity charity);
	public void saveCategory(Category category);
	}

