package com.chrisreading.cmdreddit.view;

import java.util.List;

import com.chrisreading.cmdreddit.Main;
import com.chrisreading.cmdreddit.util.StringUtils;
import com.github.jreddit.entity.Comment;
import com.github.jreddit.entity.Submission;
import com.github.jreddit.retrieval.Comments;
import com.github.jreddit.retrieval.params.CommentSort;

/**
 * View for comments
 */
public class CommentsView extends View {
	
	public CommentsView(Main main, Submission subm) {
		super(main);
		
		Comments cmts = new Comments(main.getRestClient(), main.getUser());
		List<Comment> comments = cmts.ofSubmission(subm.getIdentifier(), null, 100, -1, 100, CommentSort.HOT);
		
		for(int i = 0; i < comments.size(); i++) {
			Comment cmt = comments.get(i);
			System.out.print("[" + i + "] ");
			System.out.print("<" + cmt.getUpvotes() + "> ");
			System.out.println(cmt.getBody());
			System.out.println(StringUtils.padRight("**" + cmt.getAuthor(), 5));
		}
		
		// don't close scanner
		do {
			scanner.nextLine(); // consume last \n
			String cmd = scanner.nextLine();
			String[] args = cmd.split("\\s+"); // split the command
			
			// now parse
			if(args[0].equalsIgnoreCase("reply")) {
				if(args.length > 1) {
					 // TODO: add way to reply to comments
				} else {
					// print available options
					System.out.println("\nreply [user] [body] -- Post reply to specified user.");
				}
			}
		} while(!scanner.nextLine().equals("exit"));
	}

}
