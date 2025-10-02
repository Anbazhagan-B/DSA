package com.DsaProject.LLD.cricinfo.entity;

import LLDProblems.SnakeLadder.Player;

public class Ball {
//    int ballNumber;
//    Player bowledBy;
//    Player facedBy;
//    int runsScored;
//    Wicket wicket;
//    ExtraType extraType;
//    String commentary;
//
//    private Ball(BallBuilder ballBuilder)
//    {
//        this.ballNumber = ballBuilder.ballNumber;
//        this.bowledBy = ballBuilder.bowledBy;
//        this.facedBy = ballBuilder.facedBy;
//        this.runsScored = ballBuilder.runsScored;
//        this.wicket = ballBuilder.wicket;
//        this.extraType = ballBuilder.extraType;
//        this.commentary = ballBuilder.commentary;
//    }
//
//    public boolean isWicket()
//    {
//        return wicket != null;
//    }
//
//    public boolean isBoundary()
//    {
//        return runsScored == 4 || runsScored == 6;
//    }
//    public String getCommentary()
//    {
//        return commentary;
//    }
//
//    public int getRunsScored()
//    {
//        return runsScored;
//    }
//
//    public Player getFacedBy()
//    {
//        return facedBy;
//    }
//
//    public Player getBowledBy()
//    {
//        return bowledBy;
//    }
//
//    public Wicket getWicket() {
//        return wicket;
//    }
//
//    public ExtraType getExtraType()
//    {
//        return extraType;
//    }
//
//    public static class BallBuilder
//    {
//        int ballNumber;
//        Player bowledBy;
//        Player facedBy;
//        int runsScored;
//        Wicket wicket;
//        ExtraType extraType;
//        String commentary;
//
//        public BallBuilder withBallNumber(int ballNumber)
//        {
//            this.ballNumber = ballNumber;
//            return this;
//        }
//
//        public BallBuilder bowledBy(Player bowler)
//        {
//            this.bowledBy = bowler;
//            return this;
//        }
//
//        public BallBuilder facedBy(Player batsman)
//        {
//            this.facedBy = batsman;
//            return this;
//        }
//
//        public BallBuilder withRuns(int runs)
//        {
//            this.runsScored = runs;
//            return this;
//        }
//
//        public BallBuilder withWicket(Wicket wicket)
//        {
//            this.wicket = wicket;
//            return this;
//        }
//
//        public BallBuilder withExtraType(ExtraType extraType)
//        {
//            return  this;
//        }
//
//        public BallBuilder withCommentary(String commentary)
//        {
//            this.commentary = commentary;
//            return this;
//        }
//
//        public Ball build()
//        {
//            Ball tempBall = new Ball(this);
//
//            if(this.commentary == null)
//            {
//                this.commentary = CommentaryManager.getInstance().generateCommentary(tempBall);
//            }
//
//            return new Ball(this);
//        }
//    }
}
