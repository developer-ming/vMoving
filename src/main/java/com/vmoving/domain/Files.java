package com.vmoving.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

@Data
@Entity
@DynamicUpdate
public class Files implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8651377941719469425L;

	@Id
    private Integer id;

    private String msg;

    private String img;

    private Date createTime;

    private Date uploadTime;
}
