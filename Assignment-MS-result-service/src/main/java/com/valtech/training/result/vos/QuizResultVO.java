package com.valtech.training.result.vos;
import com.valtech.training.result.entities.QuizResult;

public record QuizResultVO(Long id, Long quizId, String userName, int score) {

    public static QuizResultVO from(QuizResult quizRes) {
        return new QuizResultVO(quizRes.getId(),quizRes.getQuizId(),quizRes.getUserName(),quizRes.getScore());
    }

    public QuizResult to() {
        return new QuizResult(this.quizId,this.userName,this.score);
    }
}
