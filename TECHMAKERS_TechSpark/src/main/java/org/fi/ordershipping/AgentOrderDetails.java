package org.fi.ordershipping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name="orderandagentdetails")
@NamedNativeQueries({
	@NamedNativeQuery(name="agent",query="insert into orderandagentdetails values(?,?,?,? )")})
public class AgentOrderDetails {
	
	@Id
	@Column(name="agentId")
	private int agentId;
	@Column (name="agentName")
	private String agentName;
	@Column (name="address")
	private String address;
	@Column (name="detailsOfProduct")
	private String detailsOfProduct;
	
	public AgentOrderDetails() {}

	public AgentOrderDetails(int agentId, String agentName, String address, String detailsOfProduct) {
		super();
		this.agentId = agentId;
		this.agentName = agentName;
		this.address = address;
		this.detailsOfProduct = detailsOfProduct;
	}

	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDetailOfProduct() {
		return detailsOfProduct;
	}

	public void setDetailOfProduct(String detailOfProduct) {
		this.detailsOfProduct = detailOfProduct;
	}
	
	
	
	
	
	
}
