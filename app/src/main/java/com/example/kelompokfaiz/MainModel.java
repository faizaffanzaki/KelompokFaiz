package com.example.kelompokfaiz;import java.util.Date;
import java.util.List;

public class MainModel {

    private List<Result> results;

    public List<Result> getResults(){
        return results;
    }

    public void setResults(List<Result> results){
        this.results = results;
    }

    public class Result{
        private boolean adult;
        private String backdrop_path;
        private List<Integer> genreIds = null;
        private int id;
        private String original_language;
        private String original_title;
        private String overview;
        private double popularity;
        private String poster_path;
        private String release_date;
        private String title;
        private boolean video;
        private double vote_average;
        private int vote_count;

        public boolean isAdult() {
            return adult;
        }

        public void setAdult(boolean adult) {
            this.adult = adult;
        }

        public String getBackdrop_path() {
            return backdrop_path;
        }

        public void setBackdrop_path(String backdrop_path) {
            this.backdrop_path = backdrop_path;
        }

        public List<Integer> getGenreIds() {
            return genreIds;
        }

        public void setGenreIds(List<Integer> genreIds) {
            this.genreIds = genreIds;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getOriginal_language() {
            return original_language;
        }

        public void setOriginal_language(String original_language) {
            this.original_language = original_language;
        }

        public String getOriginal_title() {
            return original_title;
        }

        public void setOriginal_title(String original_title) {
            this.original_title = original_title;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public double getPopularity() {
            return popularity;
        }

        public void setPopularity(double popularity) {
            this.popularity = popularity;
        }

        public String getPoster_path() {
            return poster_path;
        }

        public void setPoster_path(String poster_path) {
            this.poster_path = poster_path;
        }

        public String getRelease_date() {
            return release_date;
        }

        public void setRelease_date(String release_date) {
            this.release_date = release_date;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isVideo() {
            return video;
        }

        public void setVideo(boolean video) {
            this.video = video;
        }

        public double getVote_average() {
            return vote_average;
        }

        public void setVote_average(double vote_average) {
            this.vote_average = vote_average;
        }

        public int getVote_count() {
            return vote_count;
        }

        public void setVote_count(int vote_count) {
            this.vote_count = vote_count;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "adult=" + adult +
                    ", backdrop_path='" + backdrop_path + '\'' +
                    ", genreIds=" + genreIds +
                    ", id=" + id +
                    ", original_language='" + original_language + '\'' +
                    ", original_title='" + original_title + '\'' +
                    ", overview='" + overview + '\'' +
                    ", popularity=" + popularity +
                    ", poster_path='" + poster_path + '\'' +
                    ", release_date='" + release_date + '\'' +
                    ", title='" + title + '\'' +
                    ", video=" + video +
                    ", vote_average=" + vote_average +
                    ", vote_count=" + vote_count +
                    '}';
        }
    }
}
