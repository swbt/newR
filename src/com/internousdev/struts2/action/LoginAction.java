/**
 *
 */
package com.internousdev.struts2.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.struts2.dao.LoginDAO;
import com.internousdev.struts2.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
	
	/**フィールドの代入*/
	private String name;
	private String password;
	private Map<String,Object> session;

	
	//**結果を返すメソッド*/
	public String execute(){
		
		String ret=ERROR;
		
		//**DAO.DTOインスタンスの作成**/
		LoginDAO dao=new LoginDAO();
		LoginDTO dto=new LoginDTO();

		dto=dao.select(name,password);

		if(name.equals(dto.getName())){
			
			if(password.equals(dto.getPassword())){
				ret=SUCCESS;
			}
		}
		session.put("name", dto.getName());
		return ret;
	}

	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	
	public String getPassword(){
		return password;
	}
	public void setpassword(String password){
		this.password=password;
	}
	
	//*セッション情報*/
	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object> session){
		this.session=session;
	}
}
