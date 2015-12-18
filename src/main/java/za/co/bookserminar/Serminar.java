package za.co.bookserminar;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean
@SessionScoped
public class Serminar {

	protected String username;
	protected String email;
	
	public Serminar(){}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void validateEmail(FacesContext facesContext,UIComponent uiComponent,Object toValidate){
	
		FacesMessage message = null;
		if(toValidate.toString().indexOf("@") == -1){
			message = new FacesMessage("Invalid email address.");
			throw new ValidatorException(message);
		}
	}
	
	public String addNewUser(boolean status){
		String outcome = null;
		FacesMessage message = null;
		
		if(status){
			outcome = "success";
			message = new FacesMessage("User added successfully");
		}else{
			outcome = "failure";
			message = new FacesMessage("There was an error that occured..");
		}
		FacesContext.getCurrentInstance().addMessage(outcome, message);
		return outcome;
	}
}
