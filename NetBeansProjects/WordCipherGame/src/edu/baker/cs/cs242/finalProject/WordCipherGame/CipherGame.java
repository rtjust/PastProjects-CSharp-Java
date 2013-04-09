/*
 * @(#)CipherGame.java        1.0 9/15/10
 *
 * Copyright (c) 2010 Rob Just
 */

package edu.baker.cs.cs242.finalProject.WordCipherGame;

import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

/**
 * Class: CipherGame
 * Description: Operates the word cipher game by managing the RotCipher and
 * WordList objects that it's composed of. As a whole it generates lists from
 * a text file of words and subjects. It ciphers one word at a time and checks
 * a players guess against it until correct. Keeps track of score, hints, word,
 * subject, game over, number of words remaining, and guess attempts remaining.
 *
 *
 * @author     Rob Just
 * @created    September 15th, 2010
 */
public class CipherGame {

    private RotCipher rotCipher; // RopCipher object that ciphers the word
    private WordList wordList; // WordList object that manages the word list
    
    private String currentWord; // The current word being played
    private String currentSubject; // The current subject of word being played
    private String cipheredWord; // Ciphered version of word being played
    private String hint; // Hint string
    private String fileName; // File name of word list
    
    private int numberOfHintsGiven; // Number of hints given to the player
    private int playersScore; // Players score
    private int guessAttemptsRemaining; // Player's guess attempts remaining
    private int numberOfWordsRemaining; // Number of words in list remaining

    private boolean gameOver; // Stores whether the game is over or not
    
    // Constructor, starts new game and rethrows exceptions
    public CipherGame(String wordListFileName) throws FileNotFoundException, NoSuchElementException
    {
            fileName = wordListFileName;
            startNewGame();
    }

    // Method that starts a new game by initializing variables and creates word list
    public final void startNewGame() throws FileNotFoundException, NoSuchElementException
    {
        try
        {
            wordList = new WordList(fileName);
            rotCipher = new RotCipher();

            wordList.randomizeWordAndSubject();
            currentWord = wordList.getWord();
            currentSubject = wordList.getSubject();
            guessAttemptsRemaining = 5;
            numberOfHintsGiven = 0;
            hint = "";
            playersScore = 0;
            numberOfWordsRemaining = wordList.getNumberOfWordsRemaining();
            gameOver = false;
        }
        catch (FileNotFoundException ex)
        {
            throw ex;
        }
        catch (NoSuchElementException ex)
        {
            throw ex;
        }

    }

    // Method to to start next round only if words are remaining in list
    public void startNextRound()
    {
        if (numberOfWordsRemaining > 0)
        {
            wordList.randomizeWordAndSubject();
            currentWord = wordList.getWord();
            currentSubject = wordList.getSubject();
            guessAttemptsRemaining = 5;
            numberOfHintsGiven = 0;
            numberOfWordsRemaining = wordList.getNumberOfWordsRemaining();
            hint = "";
        }
    }

    // Method to return numberOfWordsRemaining
    public int getNumberOfWordsRemaining()
    {
        return numberOfWordsRemaining;
    }

    // Method to return ciphered word
    public String getCipheredWord()
    {
        cipheredWord = rotCipher.getRot13String(currentWord);
        return cipheredWord;
    }

    // Method to return subject of currentWord
    public String getSubject()
    {
        return currentSubject;
    }

    // Method to check players guess and return true if correct, false otherwise
    public boolean checkPlayersGuess(String playersGuess)
    {
        if (gameOver == true)
        {
            return false;
        }

        if (playersGuess.equalsIgnoreCase(currentWord))
        {
            playersScore++;
            
            if (getNumberOfWordsRemaining() <= 0)
            {
                gameOver = true;
            }
            return true;
        }
        guessAttemptsRemaining--;
        return false;
    }

    // Method to return guessAttemptsRemaining
    public int getGuessAttemptsRemaining()
    {
        return guessAttemptsRemaining;
    }

    // Method to return last hint, getNextHint gets the next hint
    public String getHint()
    {
        return hint;
    }

    // Method to return a hint, one letter at a time up to currentWord - 1
    public String getNextHint()
    {
        if (numberOfHintsGiven < currentWord.length() - 1
                && guessAttemptsRemaining > 1)
        {
            numberOfHintsGiven++;
            guessAttemptsRemaining--;
            hint = currentWord.substring(0, numberOfHintsGiven);
        }
        return hint;
    }

    // Method to return playersScore, multiplys by 10
    public int getPlayersScore()
    {
        return playersScore * 10;
    }

    // Method to return the currentWord, not ciphered
    public String getCurrentWord()
    {
        return currentWord;
    }

    // Method to check if game is over, returns true if it is over.
    public boolean getGameOver()
    {
        if (guessAttemptsRemaining <= 0 && numberOfWordsRemaining <= 0)
        {
            gameOver = true;
        }
        return gameOver;
    }

    


}
