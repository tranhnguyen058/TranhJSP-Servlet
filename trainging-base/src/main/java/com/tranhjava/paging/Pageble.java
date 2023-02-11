package com.tranhjava.paging;

import com.tranhjava.sort.Sorter;

public interface Pageble {
	Integer getPage();
	Integer	getOffset();
	Integer getLimit();
	Sorter getSorter();
}
