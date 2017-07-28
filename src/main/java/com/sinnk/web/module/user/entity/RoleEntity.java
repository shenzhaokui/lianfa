package com.sinnk.web.module.user.entity;

import com.sinnk.web.common.entity.DataEntity;

public class RoleEntity extends DataEntity<RoleEntity> {

	private static final long serialVersionUID = 1L;
	
	
	private String roleName;
	
	private String roleDescroption;
	

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDescroption() {
		return roleDescroption;
	}

	public void setRoleDescroption(String roleDescroption) {
		this.roleDescroption = roleDescroption;
	}
	
	
	

}
