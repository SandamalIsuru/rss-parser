package com.getgifted.rssparser.controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.feed.dsl.Feed;
import org.springframework.integration.transformer.AbstractPayloadTransformer;

import com.getgifted.rssparser.entity.Item;
import com.getgifted.rssparser.service.ItemService;
import com.rometools.rome.feed.synd.SyndEntry;

@Configuration
@EnableIntegration
@ComponentScan
public class RssFeedListener {

	@Value(value = "${feed.resource}")
	private Resource feedResource;

	@Autowired
	private ItemService itemService;

	@Bean
	public IntegrationFlow feedData(@Value("${max.messages.per.poll}") int maxMessagesPerPoll, @Value("${fixed.rate}") int fixedRate) {
		return IntegrationFlows
				.from(Feed.inboundAdapter(this.feedResource, "channel"), e -> e.poller(
						Pollers.fixedRate(fixedRate).maxMessagesPerPoll(maxMessagesPerPoll)
						))
				.transform(extractDataFromFeed())
				.handle(String.class, (payload, headers) -> {
			            return null;
			          })
				.get();
	}
	

	@Bean
	public AbstractPayloadTransformer<SyndEntry, Item> extractDataFromFeed() {
		return new AbstractPayloadTransformer<SyndEntry, Item>() {
			@Override
			protected Item transformPayload(SyndEntry payload) {
				System.out.println("=====================transformPayload "+payload.getUri());
				Item item = new Item();
				item.setTitle(payload.getTitle());
				item.setDescription(payload.getDescription().getValue());
				item.setGuid(payload.getUri());
				item.setPublishedDate(new Timestamp(payload.getPublishedDate().getTime()));
				return itemService.saveOrUpdateItem(item);
			}
		};

	}
}