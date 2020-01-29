package com.internousdev.latte.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.latte.dao.MCategoryDAO;
import com.internousdev.latte.dto.MCategoryDTO;
import com.internousdev.latte.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware {
	private Map<String, Object> session;
	private String tempUserId;
	private CommonUtility commonUtility = new CommonUtility();

	public String execute(){
//ログインフラグを保持していないとき、未ログインとしてログインフラグを保持する
		if(!session.containsKey("logined")) {
			session.put("logined",0);
		}
//未ログインかつ仮ユーザーIDを保持していないとき、仮ユーザーID作成
		String _logined = String.valueOf(session.get("logined"));
		int logined = "null".equals(_logined)? 0 : Integer.parseInt(_logined);
		if(logined==0 && !session.containsKey("tempUserId")) {
				tempUserId = commonUtility.getRamdomValue();
				session.put("tempUserId", tempUserId);
			}

//カテゴリー項目表示の為にリストの作成、及びリストをsession.put
		if(!session.containsKey("mCategoryDtoList")) {
			//カテゴリー項目管理のリスト
			List<MCategoryDTO> mCategoryDtoList=new ArrayList<MCategoryDTO>();
			MCategoryDAO mCategoryDAO = new MCategoryDAO();
			mCategoryDtoList = mCategoryDAO.setCategoryInfo();

			session.put("mCategoryDtoList", mCategoryDtoList);
		}
		return SUCCESS;

	}

	public Map<String,Object> getSession(){
		return this.session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
