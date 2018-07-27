package com.internousdev.webtraining.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.webtraining.dao.ItemInfoDAO;
import com.internousdev.webtraining.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemDetailsAction extends ActionSupport implements SessionAware {
	private int itemId;
	public Map<String, Object> session;
	private ItemInfoDAO itemInfoDAO = new ItemInfoDAO();
	private ItemInfoDTO itemInfoDTO = new ItemInfoDTO();

	public String execute() throws SQLException {

		session.put("itemId", itemId);

		itemInfoDTO = itemInfoDAO.getItemDatail(itemId);

		session.put("product_id", itemInfoDTO.getProduct_id());
		session.put("product_name", itemInfoDTO.getProduct_name());
		session.put("product_name_kana", itemInfoDTO.getProduct_name_kana());
		session.put("product_description", itemInfoDTO.getProduct_description());
		session.put("category_id", itemInfoDTO.getCategory_id());
		session.put("price", itemInfoDTO.getPrice());
		session.put("image_file_path", itemInfoDTO.getImage_file_path());
		session.put("image_file_name", itemInfoDTO.getImage_file_name());
		session.put("release_date", itemInfoDTO.getRelease_date());
		session.put("release_company", itemInfoDTO.getRelease_company());

		return SUCCESS;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
