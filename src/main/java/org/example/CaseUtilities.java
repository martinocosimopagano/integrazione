package org.example;

import java.util.HashSet;
import java.util.Set;

class CaseUtilities {

    /**
     * Converts all the delimiter separated words in a String into camelCase, that
     * is each word is made up of a titlecase character and then a series of
     * lowercase characters.
     *
     * <p>
     * The delimiters represent a set of characters understood to separate words.
     * The first non-delimiter character after a delimiter will be capitalized. The
     * first String character may or may not be capitalized and it's determined by
     * the user input for capitalizeFirstLetter variable.
     *
     * <p>
     * A <code>null</code> input String returns <code>null</code>. Capitalization
     * uses the Unicode title case, normally equivalent to upper case and cannot
     * perform locale-sensitive mappings.
     *
     * @param str
     *            the String to be converted to camelCase, may be null
     * @param capitalizeFirstLetter
     *            boolean that determines if the first character of first word
     *            should be title case.
     * @param delimiters
     *            set of characters to determine capitalization, null and/or empty
     *            array means whitespace
     * @return camelCase of String, <code>null</code> if null String input
     */
    public String toCamelCase(String str, final boolean capitalizeFirstLetter, final char... delimiters) {
        if (str == null || str.isEmpty()) {
            return str; // se la stringa passata è nulla o vuota la restituisce cosi com'è
        }

        /*
            NOTA BENE: I CARATTERI SONO GESTITI COME CODEPOINT
            Un codepoint in Java è un valore intero che rappresenta un carattere
         */

        str = str.toLowerCase();
        final int strLen = str.length();
        final int[] newCodePoints = new int[strLen]; // stringa finale trattata come array di codepoints
        int outOffset = 0; // contatore dei caratteri della nuova stringa
        final Set<Integer> delimiterSet = generateDelimiterSet(delimiters); // alla peggio il set contiene solo lo spazio, altrimenti anche quelli indicati come parametri, i caratteri sono sempre trattati come code points
        boolean capitalizeNext = false;
        if (capitalizeFirstLetter) {
            capitalizeNext = true;
        }

        // inizio il processo: scansione lettera per lettera
        for (int index = 0; index < strLen;) {
                final int codePoint = str.codePointAt(index); // estraggo il codepoint del carattere da considerare
                // se è un separatore faccio questo blocco e riparto con il for
                if (delimiterSet.contains(codePoint)) {
                    capitalizeNext = true;
                    if (outOffset == 0) { // anche se la stringa inizia con i separatori non capitalizza la prima lettera se non è rischiesto dal flag
                        capitalizeNext = false;
                    }
                    index += Character.charCount(codePoint); // Questo metodo restituirà 1 per i codepoint che possono essere rappresentati da un singolo char e 2 per i codepoint che richiedono una coppia surrogata.
                } // ----------------------------------------------------------
                // se non è separatore e devo rendere maiuscolo faccio questo blocco e riparto
                else if (capitalizeNext) {
                    final int titleCaseCodePoint = Character.toTitleCase(codePoint);
                    newCodePoints[outOffset++] = titleCaseCodePoint;
                    index += Character.charCount(titleCaseCodePoint);
                    capitalizeNext = false;
                } // ----------------------------------------------------------



                // se non è separatore e NON devo rendere maiuscolo faccio questo blocco e riparto
                else {
                    newCodePoints[outOffset++] = codePoint;
                    index += Character.charCount(codePoint);
                } // ----------------------------------------------------------


        }

        if (outOffset != 0) {
            return new String(newCodePoints, 0, outOffset);
        }
        return str; // se non ci sono caratteri non separatori nella stringa restituisce esattamente la stringa iniziale. perchè questa scelta?
    }

    /**
     * Converts an array of delimiters to a hash set of code points. Code point of
     * space(32) is added as the default value. The generated hash set provides O(1)
     * lookup time.
     *
     * @param delimiters
     *            set of characters to determine capitalization, null means
     *            whitespace
     * @return Set<Integer>
     */
    private Set<Integer> generateDelimiterSet(final char[] delimiters) {
        final Set<Integer> delimiterHashSet = new HashSet<>();
        delimiterHashSet.add(Character.codePointAt(new char[]{' '}, 0)); // lo spazio è di default, lo aggiunge sempre come primo delimitatore a prescindere
        if (delimiters == null || delimiters.length == 0) {
            return delimiterHashSet;
        }
        for (int index = 0; index < delimiters.length; index++) {
            delimiterHashSet.add(Character.codePointAt(delimiters, index));
        }
        return delimiterHashSet;
    }
}