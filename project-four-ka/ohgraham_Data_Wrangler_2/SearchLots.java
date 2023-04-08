// --== CS400 File Header Information ==--
// Name: Owen Graham
// Email: ohgraham@wisc.edu
// Team: KA
// Role: Data Wrangler 2
// TA: Siddarth Mohan
// Lecturer: Gary Dahl
// Notes to Grader: N/A

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SearchLots {

    /**
     * Metadata holder for ParkingLot. Counts pattern matches as it is
     * instantiated.
     */
    private static class SearchLot {
        public ParkingLot lot;
        public int weight;
        public SearchLot(ParkingLot lot, List<Pattern> partPatterns,
                         List<Pattern> wholePatterns) {
            this.lot = lot;
            this.weight = 0;
            // Put together each of the fields to be searched: address,
            // number, nearby numbers. Some fields are valued more
            // highly than others.
            List<String> greaterFields = new LinkedList<>();
            List<String> lesserFields = new LinkedList<>();
            List<String> allFields = new LinkedList<>();
            lesserFields.add(lot.address.toLowerCase());
            greaterFields.add(String.valueOf(lot.lotNumber));
            for (int i : lot.nearby) {
                lesserFields.add(String.valueOf(i));
            }
            allFields.addAll(greaterFields);
            allFields.addAll(lesserFields);
            // Test if each word is present. Return if not.
            for (Pattern pattern : partPatterns) {
                boolean foundWord = false;
                for (String field : allFields) {
                    if (pattern.matcher(field).find()) {
                        foundWord = true;
                    }
                }
                if (!foundWord) {
                    return;
                }
            }
            this.weight++;
            // Add another point for every independent occourance of a
            // searched word. The lot number counts double.
            for (Pattern pattern : wholePatterns) {
                for (String field : greaterFields) {
                    if (pattern.matcher(field).find()) {
                        this.weight += 2;
                    }
                }
                for (String field : lesserFields) {
                    if (pattern.matcher(field).find()) {
                        this.weight += 1;
                    }
                }
            }
        }
    }

    /**
     * Perform a search on a list of ParkingLot objects.
     *
     * @param lots Lots to seearch through
     * @param search Plain search string (make sure this is URL-unescaped with
     * java.net.URLDecoder.decode(escapedSearch, "UTF-8"))
     * @return List of matches, sorted by descending matchiness.
     */
    public static List<ParkingLot> sort(List<ParkingLot> lots, String search) {
        // Normalize and escape `search` into a suitable regex pattern.
        search = search.trim()
                       .toLowerCase()
                       .replaceAll("([\\Q\\$^*()+{}[]|.?\\E])", "\\\\$1")
                       .replaceAll("[ ]{2,}", " ");
        // Containing every word in the search string is one point.
        // One extra point for every word that's contained on its own
        // (not part of other words).
        List<Pattern> partPatterns = new LinkedList<>();
        List<Pattern> wholePatterns = new LinkedList<>();
        for (String word : search.split(" ")) {
            partPatterns.add(Pattern.compile(word));
            wholePatterns.add(Pattern.compile("\\b" + word + "\\b"));
        }
        List<ParkingLot> sorted =
            lots.stream()
                // Convert to SearchLot, counting search matches on each
                // item.
                .map((lot) -> new SearchLot(lot, partPatterns, wholePatterns))
                // Filter out non-matches.
                .filter((sLot) -> sLot.weight > 0)
                // Sort by descending matchiness.
                .sorted((sLot, otherSLot) -> otherSLot.weight - sLot.weight)
                // Convert back to ParkingLot.
                .map((sLot) -> sLot.lot)
                .collect(Collectors.toList());
        return sorted;
    }

}
