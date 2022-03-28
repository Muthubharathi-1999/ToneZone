package com.example.demo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "service_centers")
public class ServiceCenter extends BaseModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name", nullable = true, length = 20)
	private String name;
	
	@Column(nullable = false, length = 45)
	private String email;
	
	@Column(nullable = true)
	private String img_url;

    @Column(nullable = false)
	private String describtion;

    @Column(nullable = false)
	private float raiting = 0.0f;
	
	public long getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
    
    public String getEmail() {
        return this.email;
    }

    public String getImageUrl() {
        return this.img_url;
    }

    public String getDescribtion() {
        return this.describtion;
    }

    public float getRating() {
        return this.raiting;
    }

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    public void setImageUrl(String img_url) {
        this.img_url = img_url;
    }

    public void setDescribtion(String describtion) {
        this.describtion = describtion;
    }

    public void setRating(float raiting) {
        this.raiting = raiting;
    }

	@Override
	public String toString() {
		return "\"ServiceCenter [id" + this.getId() + ",name" + this.getName() + ",email" + this.getEmail() + ",describtion" + this.getDescribtion() + ",rating" + this.getRating() + "]";
	}
}