package com.chrisreading.cmdreddit.view;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.chrisreading.cmdreddit.Main;
import com.chrisreading.cmdreddit.util.OpenUtils;
import com.github.jreddit.entity.Submission;
import com.github.jreddit.retrieval.Submissions;
import com.github.jreddit.retrieval.params.SubmissionSort;

/**
 * Shows a subreddit
 */
public class SubredditView extends View {

	public SubredditView(Main main, String sub) {
		super(main);
		Submissions subms = new Submissions(main.getRestClient(), main.getUser());
		List<Submission> submissions = subms.ofSubreddit(sub, SubmissionSort.HOT, -1, 25, null, null, true);
		
		System.out.println("Showing submissions from " + sub + "\n");
		
		// load all posts
		for(int i = 0; i < submissions.size(); i++) {
			Submission subm = submissions.get(i);
			System.out.println(i + " " + subm.getTitle());
			System.out.println("  " + subm.getURL());
			System.out.println("  " + subm.getUpVotes());
			System.out.println("  " + subm.getAuthor() + " | " + subm.getSubreddit());
		}
		
		// TODO: Add more parsing
		if(scanner.next().startsWith("open")) {
			Submission subm = submissions.get(scanner.nextInt());
			try {
				OpenUtils.openLink(new URL(subm.getURL()));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
	}

}
