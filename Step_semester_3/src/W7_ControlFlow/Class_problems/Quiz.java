class Scorecard {
    private final boolean[] results;
    private int answerCount;
    private int score;

    Scorecard(int totalQuestions) {
        results = new boolean[totalQuestions];
        answerCount = 0;
        score = 0;
    }

    public void recordAnswer(boolean correct) {
        if (answerCount < results.length) {
            results[answerCount] = correct;
            answerCount++;

            if (correct) {
                score++;
            }
        }
    }

    public int getScore() {
        return score;
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println(sc.getScore());
    }
}