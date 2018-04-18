package edu.rosehulman.moviequotes;

import android.support.annotation.NonNull;

import com.google.firebase.firestore.Exclude;
import com.google.firebase.firestore.ServerTimestamp;

import java.util.Comparator;
import java.util.Date;

/**
 * Created by Matt Boutell on 12/15/2015, based on earlier work by Dave Fisher.
 */
public class MovieQuote implements Comparable<MovieQuote> {

  @Exclude
  public String id;

  public String quote;
  public String movie;

  @ServerTimestamp
  public Date created;

  public MovieQuote() {
    // Required.  Do not remove.
  }

  public MovieQuote(String quote, String movie) {
    this.movie = movie;
    this.quote = quote;
  }

  public int compareTo(@NonNull MovieQuote o) {
    if (this.created != null && o.created != null){
      return -created.compareTo(o.created);
    } else if (this.created == null){
      return -1;
    } else {
      return 1;
    }
  }
}
