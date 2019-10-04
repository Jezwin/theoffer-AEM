package com.auki.core.models;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import com.auki.core.services.OfferService;


@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class OfferServiceModel {


	@Inject
	private String text;

	@Inject
	private String eventStartDate;

	@Inject
	private String eventEndDate;

	@Inject
	private OfferService offerService;

	private ArrayList<OfferModel> offerListReturn = new ArrayList<>();


	public ArrayList<OfferModel> getOfferListReturn() {
		return offerListReturn;
	}





	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}



	public String getEventStartDate() {
		return eventStartDate;
	}


	public void setEventStartDate(String eventStartDate) {
		this.eventStartDate = eventStartDate;
	}


	public String getEventEndDate() {
		return eventEndDate;
	}


	public void setEventEndDate(String eventEndDate) {
		this.eventEndDate = eventEndDate;
	}

	@PostConstruct
	protected void init() {

		offerListReturn = offerService.ListOffer();
	}

}
