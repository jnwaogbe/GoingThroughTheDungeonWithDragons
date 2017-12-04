package dragondungeongame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Me
 */

import java.util.Random;
import java.util.Scanner;


public class WordGame {
    
    public String level;
    
    
    WordGame(String dlevel){
        level = dlevel;
        
    }
    /**
     * 
     * 
     *
     */
    public Scanner reader = new Scanner(System.in);
    public boolean shouldPlay = true;
    public int qAsked = 0;
    public boolean Win = true;
    public Random rand = new Random();
    public int numOfQs;
    
    public int questionsAsked[] = new int[10];
    
    
       
   
    
    
    
    public String [][] questions = {{"Which of these is an ellipses?", "...", "!", "?", ".", "1"}, //0
                        {"Which word is an antoynm of abnegation?", "self-denial", "austerity", "surrender", "self-indulgence", "4"}, //1
                        {"Who played Mr. Spock in Star Trek: The Original Series?", "William Shatner", "Leonard McCoy", "Leonard Nimoy", "Willam Clinton", "2"},
                        {"Should Karl make jerk chicken for the class?", "Definitely", "Why hasn't he yet?", "Uh, no.", "What about the vegans?", "2"},
                        {"In November 2017, a trailer was released for the Incredibles 2. In what month did the trailer say the movie was to come out?", "November", "December", "June", "July", "3"},
                        {"Who wrote the novel, Perelandra?", "C.S. Lewis", "Lemony Snickett", "J.R.R Tolkien", "Charles Dickens", "1"},//5
                        {"Who is the creator of Star Trek?", "Gene Roddenberry", "George Lucas", "Mike George", "JJ Abrams", "1"},
                        {"Who is the CEO of QVC?", "George Lucas", "George Smith", "Mike George", "Josh George"}, 
                        {"Which of the Pevensie children meets the White Witch first?", "Lucy", "Peter", "Edmund", "Susan", "3"},//8
                        {"Who sings 'Oops, I did it again'?", "Rihanna", "Britney Spears", "Gwen Stefani", "Jessica Simpson", "2"},
                        {"Who plays Barney on The Andy Griffith Show?", "Andy Griffith", "Andy Taylor", "Barney Fife", "Don Knotts", "4"},//10
                        {"True or False: The brand Mt. Olive sells pickles", "true", "false", "1"},
                        {"Which of these movies/series did John Williams not compose the soundtrack for?", "Star Wars", "Home Alone", "Jurassic Park", "Lord of the Rings", "4"}
    };
   
    
    public void setLevel(String level){
        
        level = level.toLowerCase();
        
        switch (level) {
            case "easy":
                numOfQs = 3;
                break;
            case "medium":
                numOfQs = 5;
                break;
            case "hard":
                numOfQs = 10;
                break; 
        }
        
    }
    
    public int PresentQuestion(){
        int qnum = rand.nextInt(questions.length);
        while(compareQuestionNumber(qnum)==true){
            
            qnum++;
            if(qnum == (questions.length)){
                qnum = 0;
            }
        }
        
        questionsAsked[qAsked] = qnum;
        qAsked++;
        
        System.out.println("\n ************************************ \nThis is your question. \n ************************************ \n" 
                            + questions[qnum][0] 
                            + "\n 1. " + questions[qnum][1]
                            + "\n 1. " + questions[qnum][2]
                            + "\n 1. " + questions[qnum][3]
                            + "\n 1. " + questions[qnum][4]
                            + "\n Choose your answer carefully"    
                
                );
        
        
        
        return qnum;
        
    }
    
    //This method will check if the question has already been asked.    
    public boolean compareQuestionNumber(int number){
        
        
        int i = questionsAsked.length;
        i--;
        boolean hasBeenAsked = false;
        
       while(i<questionsAsked.length){
           if(questionsAsked[i]==number){
               hasBeenAsked = true;
               return hasBeenAsked;
           }
           else{
               
               i++;
               
           }
       }
        
        
        return false;
    }
    
    //This method will check if the user's answer is correct.
    public boolean CheckAnswer(int questionNumber, int userInput){
        
        String answer = Integer.toString(userInput);
        String correctAnswer = questions[questionNumber][5];
                     
        return answer.equals(correctAnswer);
    }
    
    public boolean Game(){
        System.out.println("Welcome, Traveller! \n I see you have bested the beast! It would be in your best interest to befriend her.\n "
                + "Even if she is wounded by you, a simple test can prove your worthiness for her to aid you.\n Trust me. You will need her help.\n"
                + "When presented with a question. Please press the key of the corresponding to the answer you beleive is correct.\n"
                + "If you are incorrect, you will lose any growing trust she might have for you. \n"
                + "Good luck, Traveller.");
        
        int loop = 0;
        
        while((loop<numOfQs) && (Win == true)){
        
        
            int questionNumber = PresentQuestion();
            int userInput = reader.nextInt();
            Win = CheckAnswer(questionNumber, userInput); 
            
            loop++;
            
        }
        
        reader.close();
     
    
    return Win;
}
}
                        
                
    
    
    
   
    

