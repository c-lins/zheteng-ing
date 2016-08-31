package org.lins.hystrix.command.batching;

import com.netflix.hystrix.HystrixCollapser.CollapsedRequest;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixThreadPoolKey;
import org.lins.hystrix.service.BettingService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BatchCommandGetOddsForHorse extends HystrixCommand<List<String>> {

	private final Collection<CollapsedRequest<String, GetOddsForHorseRequest>> requests;

	private BettingService service;

	public BatchCommandGetOddsForHorse(Collection<CollapsedRequest<String, GetOddsForHorseRequest>> requests) {
		super(Setter.withGroupKey(
				HystrixCommandGroupKey.Factory.asKey("BettingServiceGroup"))
				.andThreadPoolKey(
						HystrixThreadPoolKey.Factory.asKey("GetOddsPool")));
		this.requests = requests;
	}
	
	@Override
	protected List<String> run() {
		ArrayList<String> response = new ArrayList<String>();
        for (CollapsedRequest<String, GetOddsForHorseRequest> request : requests) {
        	GetOddsForHorseRequest callRequest = request.getArgument();
        	response.add(service.getOddsForHorse(callRequest.getRaceCourseId(), callRequest.getHorseId()));
        }
        return response;
	}
	
	public void setService(BettingService service) {
		this.service = service;
	}
		
}