package br.com.project.listener;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "utils")
public class Utils {
	   
    private String text;
 
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
     
    public void handleKeyEvent() {
        text = text.toUpperCase();}
}
