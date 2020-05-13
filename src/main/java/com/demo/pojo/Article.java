package com.demo.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

@Getter
@Setter
@Document(indexName="article",type="docs")
public class Article implements Serializable {
	@Id
	private Long id;
	@Field(type = FieldType.Text, analyzer = "ik_max_word")
	private String title;
	@Field(type = FieldType.Text, analyzer = "ik_max_word")
	private String content;
	@Field(type = FieldType.Text, analyzer = "ik_max_word")
	private String author;

	public Article() {
	}

	public Article(Long id, String title, String content, String author) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.author = author;
	}

	@Override
	public String toString() {
		return "Article{" +
				"id=" + id +
				", title='" + title + '\'' +
				", content='" + content + '\'' +
				", author='" + author + '\'' +
				'}';
	}
}