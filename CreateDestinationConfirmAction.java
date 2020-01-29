package com.internousdev.latte.action;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.latte.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class CreateDestinationConfirmAction extends ActionSupport implements SessionAware{

	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String userAddress;
	private String telNumber;
	private String email;
	private Map<String,Object> session;

	private List<String> familyNameError;
	private List<String> firstNameError;
	private List<String> familyNameKanaError;
	private List<String> firstNameKanaError;
	private List<String> userAddressError;
	private List<String> telNumberError;
	private List<String> emailError;

	public String execute() {
		String result = ERROR;;

		session.put("familyName", familyName);
		session.put("firstName", firstName);
		session.put("familyNameKana", familyNameKana);
		session.put("firstNameKana", firstNameKana);
		session.put("email", email);
		session.put("telNumber", telNumber);
		session.put("userAddress", userAddress);


		//ログインフラグ定義

		String tempLogined = String.valueOf(session.get("logined"));
		int logined = "null".equals(tempLogined)? 0 : Integer.parseInt(tempLogined);
		if(logined != 1) {
			return "loginError";
		}

		// なぜやるのか：
		// 住所がスペースのみでも登録ができてしまうのは良くないため
		// スペースのみ入力されている場合はエラーとしたいため。
		String tempUserAddress = null;
			if (StringUtils.isBlank(userAddress) && !"".equals(userAddress)){
				//住所にスペースを入力された場合は処理用の変数に"@@@"を代入
				tempUserAddress = "@@@";
			} else {
				// 住所が未入力、もしくは住所にスペース以外を入力された処理用の変数に入力した値を代入
				tempUserAddress = userAddress;
			}

			InputChecker inputChecker = new InputChecker();

			familyNameError = inputChecker.doCheck("姓", familyName, 1, 16, true, true, true, false, true, false);
			firstNameError = inputChecker.doCheck("名", firstName, 1, 16, true, true, true, false, true, false);
			familyNameKanaError = inputChecker.doCheck("姓ふりがな", familyNameKana, 1, 16, false, false, true, false, false,
					false);
			firstNameKanaError = inputChecker.doCheck("名ふりがな", firstNameKana, 1, 16, false, false, true, false, false,
					false);
			userAddressError = inputChecker.doCheck("住所", tempUserAddress, 10, 50, true, true, true, true, true, true);
			telNumberError = inputChecker.doCheck("電話番号", telNumber, 10, 13, false, false, false, true, false, false);
			emailError = inputChecker.doCheckForEmail(email);

			if (familyNameError.size() > 0
					|| firstNameError.size() > 0
					|| familyNameKanaError.size() > 0
					|| firstNameKanaError.size() > 0
					|| userAddressError.size() > 0
					|| telNumberError.size() > 0
					|| emailError.size() > 0) {

				result = ERROR;
			}else {
				result=SUCCESS;
			}

		return result;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFamilyNameKana() {
		return familyNameKana;
	}

	public void setFamilyNameKana(String familyNameKana) {
		this.familyNameKana = familyNameKana;
	}

	public String getFirstNameKana() {
		return firstNameKana;
	}

	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public List<String> getFamilyNameError() {
		return familyNameError;
	}

	public void setFamilyNameError(List<String> familyNameError) {
		this.familyNameError = familyNameError;
	}

	public List<String> getFirstNameError() {
		return firstNameError;
	}

	public void setFirstNameError(List<String> firstNameError) {
		this.firstNameError = firstNameError;
	}

	public List<String> getFamilyNameKanaError() {
		return familyNameKanaError;
	}

	public void setFamilyNameKanaError(List<String> familyNameKanaError) {
		this.familyNameKanaError = familyNameKanaError;
	}

	public List<String> getFirstNameKanaError() {
		return firstNameKanaError;
	}

	public void setFirstNameKanaError(List<String> firstNameKanaError) {
		this.firstNameKanaError = firstNameKanaError;
	}

	public List<String> getUserAddressError() {
		return userAddressError;
	}

	public void setUserAddressError(List<String> userAddressError) {
		this.userAddressError = userAddressError;
	}

	public List<String> getTelNumberError() {
		return telNumberError;
	}

	public void setTelNumberError(List<String> telNumberError) {
		this.telNumberError = telNumberError;
	}

	public List<String> getEmailError() {
		return emailError;
	}

	public void setEmailError(List<String> emailError) {
		this.emailError = emailError;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
