package com.shin.multi_filters.service;

import com.shin.multi_filters.common.FilterCriteria;
import com.shin.multi_filters.common.FilterSortAndPageRequest;
import com.shin.multi_filters.common.SortCriteria;
import com.shin.multi_filters.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Page<?> findByCriteria(FilterSortAndPageRequest filterSortAndPageRequest) {
        List<FilterCriteria> filters = filterSortAndPageRequest.getFilterCriteriaList();
        Boolean andClause = filterSortAndPageRequest.getAndClause();
        Integer pageNumber = filterSortAndPageRequest.getPageNumber();
        Integer pageSize = filterSortAndPageRequest.getPageSize();
        List<SortCriteria> sortList = filterSortAndPageRequest.getSortCriteriaList();
        return employeeRepository.findAllByCriteria(filters, andClause, pageNumber, pageSize, sortList);
    }
}
