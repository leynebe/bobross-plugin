/**
 * Copyright (c) 2009 Cliffano Subagio
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package hudson.plugins.bobross;

import java.util.Random;

/**
 * {@link FactGenerator} provides Bob Ross facts.
 * @author cliffano
 */
public class FactGenerator {

    // Original Bob Ross quotes found here: https://www.goodreads.com/author/quotes/102372.Bob_Ross
      
    private static final String[] FACTS = {
            "There are no bugs or failed pipelines, there are only happy little accidents.",
            "Keeping your pipeline green is a pursued interest. Anything that you're willing to practice, you can do.",
            "There's nothing wrong with having a failing pipeline as a friend.",
            "I guess I’m a little weird. I like to talk to my cicd tools. That’s okay though; I have more fun than most people.",
            "Let's get crazy.",
            "I can't think of anything more rewarding than being able to express yourself to others through rigid deployment pipelines. Exercising the imagination, experimenting with talents, being creative; these things, to me, are truly the linux to your soul.",
            "The secret to doing anything is believing that you can do it. Anything that you believe you can do strong enough, you can do. Anything. As long as you believe.",
            "All you need to automate is a few tools, a little instruction, and a vision in your mind.",
            "See a Windows machine, just beats the devil out of it. *chuckles*",
            "Mix up a little more pipeline dsl here, then we can put us a bash script right in there. See how you can move things around? You have unlimited power on this server -- can literally, literally move files across the world",
            "Believe that you can do it cause you can do it.",
            "I started messing around with Linux as a hobby when I was little. I didn't know I had any talent. I believe talent is just a pursued interest. Anybody can do what I do.",
            "This is your world. You’re the creator. Find freedom on this automation server. Believe, that you can do it, 'Cuz you can do it. You can do it.",
            "Let's provision a happy little cloud. Lets build some happy little applications.",
            "There's nothing in the world that breeds success like success.",
            "Let's get a little crazy here.",
            "What can be scripted can be punished.",
            "On AWS there are no mistakes, only happy little catastrophes.", 
            "Now then, let's come right down in here and put some nice big strong naming conventions on these git branches. Branch needs an fork too. It'll hold up the weight of the repository. Little webhook has to have a place to set there. There he goes...",
            "Bob Ross doesn't throw exceptions, he cannot help but put them down gently and admire them for being their own unique selves.",
            "Bob Ross uses revision control software so he can look back on his mistakes and learn from them.",
            "Bob Ross' afro isn't immutable, if it could ask nicely Bob would probably be inclined to change his style."
            
            // "All arrays Bob Ross declares are of infinite size, because Bob Ross knows no bounds.",
            // "Bob Ross doesn't have disk latency because the hard drive knows to hurry the hell up.",
            // "All browsers support the hex definitions #chuck and #norris for the colors black and blue.",
            // "Bob Ross can't test for equality because he has no equal.",
            // "Bob Ross doesn't need garbage collection because he doesn't call .Dispose(), he calls .DropKick().",
            // "Bob Ross's first program was kill -9.",
            // "Bob Ross burst the dot com bubble.",
            // "Bob Ross writes code that optimizes itself.",
            // "Bob Ross can write infinite recursion functions... and have them return.",
            // "Bob Ross can solve the Towers of Hanoi in one move.",
            // "The only pattern Bob Ross knows is God Object.",
            // "Bob Ross finished World of Warcraft.",
            // "Project managers never ask Bob Ross for estimations... ever.",
            // "Bob Ross doesn't use web standards as the web will conform to him.",
            // "\"It works on my machine\" always holds true for Bob Ross.",
            // "Whiteboards are white because Bob Ross scared them that way.",
            // "Bob Ross's Afro can type 140 wpm.",
            // "Bob Ross can unit test an entire application with a single assert.",
            // "Bob Ross doesn't bug hunt, as that signifies a probability of failure. He goes bug killing.",
            // "Bob Ross's keyboard doesn't have a Ctrl key because nothing controls Bob Ross.",
            // "Bob Ross doesn't need a debugger, he just stares down the bug until the code confesses.",
            // "Bob Ross can access private methods.",
            // "Bob Ross can instantiate an abstract class.",
            // "Bob Ross doesn't need to know about class factory pattern. He can instantiate interfaces.",
            // "The class object inherits from Bob Ross.",
            // "For Bob Ross, NP-Hard = O(1).",
            // "Bob Ross knows the last digit of PI.",
            // "Bob Ross can divide by zero.",
            // "Bob Ross doesn't get compiler errors, the language changes itself to accommodate Bob Ross.",
            // "The programs that Bob Ross writes don't have version numbers because he only writes them once. If a user reports a bug or has a feature request they don't live to see the sun set.",
            // "Bob Ross doesn't believe in floating point numbers because they can't be typed on his binary keyboard.",
            // "Bob Ross solved the Travelling Salesman problem in O(1) time.",
            // "Bob Ross never gets a syntax error. Instead, the language gets a DoesNotConformToChuck error.",
            // "No statement can catch the BobRossException.",
            // "Bob Ross doesn't program with a keyboard. He stares the computer down until it does what he wants.",
            // "Bob Ross doesn't pair program.",
            // "Bob Ross can write multi-threaded applications with a single thread.",
            // "There is no Esc key on Bob Ross' keyboard, because no one escapes Bob Ross.",
            // "Bob Ross doesn't delete files, he blows them away.",
            // "Bob Ross can binary search unsorted data.",
            // "Bob Ross breaks RSA 128-bit encrypted codes in milliseconds.",
            // "Bob Ross went out of an infinite loop.",
            // "Bob Ross can read all encrypted data, because nothing can hide from Bob Ross.",
            // "Bob Ross hosting is 101% uptime guaranteed.",
            // "When a bug sees Bob Ross, it flees screaming in terror, and then immediately self-destructs to avoid being roundhouse-kicked.",
            // "Bob Ross rewrote the Google search engine from scratch.",
            // "Bob Ross doesn't need the cloud to scale his applications, he uses his laptop.",
            // "Bob Ross can access the DB from the UI.",
            // "Bob Ross' protocol design method has no status, requests or responses, only commands.",
            // "Bob Ross' programs occupy 150% of CPU, even when they are not executing.",
            // "Bob Ross can spawn threads that complete before they are started.",
            // "Bob Ross programs do not accept input.",
            // "Bob Ross doesn't need an OS.",
            // "Bob Ross can compile syntax errors.",
            // "Bob Ross compresses his files by doing a flying round house kick to the hard drive.",
            // "Bob Ross doesn't use a computer because a computer does everything slower than Bob Ross.",
            // "You don't disable the Bob Ross plug-in, it disables you.",
            // "Bob Ross doesn't need a java compiler, he goes straight to .war",
            // "Bob Ross can use GOTO as much as he wants to. Telling him otherwise is considered harmful.",
            // "There is nothing regular about Bob Ross' expressions.",
            // "Quantum cryptography does not work on Bob Ross. When something is being observed by Chuck it stays in the same state until he's finished. ",
            // "There is no need to try catching Bob Ross' exceptions for recovery; every single throw he does is fatal.",
            // "Bob Ross' Afro is immutable.",
            // "Bob Ross' preferred IDE is hexedit.",
            // "Bob Ross is immutable. If something's going to change, it's going to have to be the rest of the universe.",
            // "Bob Ross' addition operator doesn't commute; it teleports to where he needs it to be.",
            // "Anonymous methods and anonymous types are really all called Bob Ross. They just don't like to boast.",
            // "Bob Ross doesn't have performance bottlenecks. He just makes the universe wait its turn.",
            // "Bob Ross does not use exceptions when programming. He has not been able to identify any of his code that is not exceptional.",
            // "When Bob Ross' code fails to compile the compiler apologises.",
            // "Bob Ross does not use revision control software. None of his code has ever needed revision.",
            // "Bob Ross can recite π. Backwards.",
            // "When Bob Ross points to null, null quakes in fear.",
            // "Bob Ross has root access to your system.",
            // "When Bob Ross gives a method an argument, the method loses",
            // "Bob Ross' keyboard doesn't have F1 key, the computer asks for help from him.",
            // "Bob Ross is too hard for soft deletes.",
            // "Bob Ross doesn’t do Burn Down charts, he does Smack Down charts.",
            // "Bob Ross can delete the Recycling Bin.",
            // "When Bob Ross presses Ctrl+Alt+Delete, worldwide computers restart is initiated.",
            // "When Bob Ross throws exceptions, it’s across the room.",
            // "When Bob Ross is web surfing websites get the message \"Warning: Internet Explorer has deemed this user to be malicious or dangerous. Proceed?\"."
    };

    /**
     * Random instance.
     */
    private static final Random RANDOM = new Random();

    /**
     * Retrieves a random fact.
     * @return a random fact
     */
    public String random() {
        return FACTS[RANDOM.nextInt(FACTS.length)];
    }
}
