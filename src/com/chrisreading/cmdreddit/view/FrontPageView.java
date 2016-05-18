package com.chrisreading.cmdreddit.view;

import java.util.List;

import com.chrisreading.cmdreddit.Main;
import com.github.jreddit.entity.Submission;
import com.github.jreddit.entity.Subreddit;
import com.github.jreddit.retrieval.Submissions;
import com.github.jreddit.retrieval.params.SubmissionSort;

/**
 * Shows the front page of reddit
 * 
 * TODO: MAKE IT ACTUALLY WORK!
 */
public class FrontPageView extends View {

	/** Submissions on the front page */
	private List<Submission> submissions;
	
	/** Subscribed subreddits */
	private List<Subreddit> subscribedSubs;
	
	public FrontPageView(Main main) {
		super(main);
		
		// init submissions use
		Submissions subms = new Submissions(main.getRestClient(), main.getUser());
		subscribedSubs = main.getUser().getSubscribed(150); // get subscribed subreddits
		
		// add top "hot" submissions from each subreddit
		for(int i = 0; i < subscribedSubs.size(); i++) {
			submissions.addAll(subms.ofSubreddit(subscribedSubs.get(i).getDisplayName(), SubmissionSort.HOT, -1, 1, null, null, true));
		}
		
		// load all posts on front page
		for(int i = 0; i < submissions.size(); i++) {
			Submission subm = submissions.get(i);
			System.out.println(i + " " + subm.getTitle());
			System.out.println("  " + subm.getURL());
			System.out.println("  " + subm.getUpVotes());
			System.out.println("  " + subm.getAuthor() + " | " + subm.getSubreddit());
		}
	}

}
