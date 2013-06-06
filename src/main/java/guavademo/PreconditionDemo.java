package guavademo;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PreconditionDemo {
    private List<Integer> scores;

    public PreconditionDemo() {
        this.scores = new ArrayList<Integer>();
    }

    public void addScoreOldJavaWay(Integer score) {
        if (score == null) throw new NullPointerException();
        if (score < 0 || score > 10) 
        	throw new IllegalArgumentException("Score must be between 0 and 10");
        this.scores.add(score);
    }
    
    public void addScore(Integer score) {
        checkNotNull(score);
        checkArgument(score >= 0 && score <= 10, 
                "Score must be between 0 and 10");
        this.scores.add(score);
    }

    public Integer getHighestScore() {
        checkState(scores != null, "Scores are not set");
        checkState(scores.size() > 0, "No scores are entered");
        return Collections.max(this.scores);
    }
}
