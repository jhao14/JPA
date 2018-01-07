package com.example.jpa.many2manyboth;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Table(name = "JPA_ITEMS")
@Entity
public class Item {
	private Integer id;
	private String itemName;

	private Set<Category> categories = new HashSet<>();

	@GeneratedValue
	@Id
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
    @Column(name="ITEM_NAME")
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	//使用@ManyToMany注解来映射多对多关联关系
	//1.name指向中间表的名字
	//2.joinColimns映射当前类所在的表在中间表的外键
	//2.1 name指定外键列的列名
	//2.2 referencedColumnName指定外键列关联当前表的哪一列
	//3.inverseJoinColumns 映射关联的类所在中间表的外键
	@JoinTable(name="ITEM_CATEGORY"
	,joinColumns={@JoinColumn(name="ITEM_ID",referencedColumnName="ID")}
	,inverseJoinColumns={@JoinColumn(name="CATEGORY_ID",referencedColumnName="ID")})
    @ManyToMany
	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

}
