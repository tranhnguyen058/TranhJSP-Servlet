package com.tranhjava.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.tranhjava.model.NewModel;

public class NewMapper implements RowMapper<NewModel> {

	@Override
	public NewModel mapRow(ResultSet resultSet) {
		
		
		try {
			NewModel news = new NewModel();
			news.setId(resultSet.getLong("id"));
			news.setTitle(resultSet.getString("title"));
			news.setContent(resultSet.getString("content"));
			news.setCategoryId(resultSet.getLong("categoryid"));
			news.setThumbnail(resultSet.getString("thumbnail"));
			news.setShortDescription(resultSet.getString("shortdescription"));
			news.setCreatedBy(resultSet.getString("createdby"));
			news.setCreatedDate(resultSet.getTimestamp("createddate"));
			if(resultSet.getTimestamp("modifieddate") != null) {
				news.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			} if(resultSet.getString("modifiedby") != null) {
				news.setModifiedBy(resultSet.getString("modifiedby"));
			}
			return news;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null ;
		}
	}

}
