package br.com.project.bean.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class ImagesView {
     
    private List<String> imagese;
     
    @PostConstruct
    public void init() {
        imagese = new ArrayList<String>();
        for (int i = 11; i <= 28; i++) {
            imagese.add( i + ".PNG");
        }
    }
 
    public List<String> getImages() {
        return imagese;
    }
}