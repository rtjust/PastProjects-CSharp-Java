/*
 * @(#)WordList.java        1.0 9/15/10
 *
 * Copyright (c) 2010 Rob Just
 */

package edu.baker.cs.cs242.finalProject.WordCipherGame;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

/**
 * Class: WordList
 * Description: Class that manages the word list used by the class CipherGame.
 * Imports words and subjects from a file, sorts them, and randomly selects a
 * word and subject to be played by CipherGame. Keeps track of words used.
 *
 *
 * @author     Rob Just
 * @created    September 15th, 2010
 */
public class WordList {

    private ArrayList<String> usedWordsArrayList; // Stores used words
    private ArrayList<String> wordArrayList; // Stores word list from file
    private ArrayList<String> subjectArrayList; // Stores subject list from file
    private String wordListFileName; // Stores word list file name
    private String word; // Stores current word from list
    private String subject; // Stores current subject from file

    private int numberOfWordsRemaining; // Stores number of words remaining in list

    private Random randomGenerator; // Used for randomly selecting a word

    // Constructor that inits lists and calls loadWordListFromFile
    public WordList(String wordListFileName) throws FileNotFoundException, NoSuchElementException
    {
        usedWordsArrayList = new ArrayList<String>();
        wordArrayList = new ArrayList<String>();
        subjectArrayList = new ArrayList<String>();

        randomGenerator = new Random();

        this.wordListFileName = wordListFileName;

        try
        {
            loadWordListFromFile();
            numberOfWordsRemaining = wordArrayList.size();
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

    // Method to load words and subjects from file and put in ArrayLists
    private void loadWordListFromFile() throws FileNotFoundException, NoSuchElementException
    {
        try
        {
            Scanner inFile = new Scanner(new FileReader(wordListFileName));
            // Read each line from file and add to wordArrayList and subjectArrayList
            while (inFile.hasNext()) {
                subjectArrayList.add(inFile.next());
                wordArrayList.add(inFile.next());
            }

            inFile.close(); // Close the file
        }
        catch (FileNotFoundException ex)
        {
            throw ex;
        }
        catch (NoSuchElementException ex)
        {
            throw ex;
        }

        sortArrayListsBySubject();
    }

    // Method to sort the word and subject ArrayLists in parallel by the subject A-Z
    private void sortArrayListsBySubject()
    {
        int firstOutOfOrder, location;
        String tempWord;
        String tempSubject;

        for (firstOutOfOrder = 1; firstOutOfOrder
                < subjectArrayList.size(); firstOutOfOrder++) {

            if (subjectArrayList.get(firstOutOfOrder).compareToIgnoreCase(subjectArrayList.get(firstOutOfOrder - 1)) < 0) {
                tempWord = wordArrayList.get(firstOutOfOrder);
                tempSubject = subjectArrayList.get(firstOutOfOrder);

                location = firstOutOfOrder;

                do
                {
                    wordArrayList.set(location, wordArrayList.get(location - 1));
                    subjectArrayList.set(location, subjectArrayList.get(location - 1));
                    location--;
                }
                while (location > 0 && subjectArrayList.get(location - 1).compareToIgnoreCase(tempSubject) > 0);

                wordArrayList.set(location, tempWord);
                subjectArrayList.set(location, tempSubject);
            }
        }
    }

    // Method to select a random word and subject from the list
    public void randomizeWordAndSubject()
    {
        int wordListSize = wordArrayList.size();
        int randomInt = randomGenerator.nextInt(wordListSize);

        if (numberOfWordsRemaining > 0)
        {
            while (usedWordsArrayList.contains(wordArrayList.get(randomInt)))
            {
                randomInt = randomGenerator.nextInt(wordListSize);
            }

            word = wordArrayList.get(randomInt);
            subject = subjectArrayList.get(randomInt);

            usedWordsArrayList.add(word);
            numberOfWordsRemaining--;
        }
        
    }

    // Method to return the word selected in randomizeWordAndSubject
    public String getWord()
    {
        return word;
    }

    // Method to return the subject selected in randomizeWordAndSubject
    public String getSubject()
    {
        return subject;
    }

    /// Method to return the number of unused words remaining in list
    public int getNumberOfWordsRemaining()
    {
        return numberOfWordsRemaining;
    }


}
