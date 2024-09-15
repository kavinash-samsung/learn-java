package com.avinash;

import java.nio.charset.StandardCharsets;

public class FullTextSearchApp {
    private static String docContent(String docId){
        try{
            var inputStream = FullTextSearchApp.class.getResourceAsStream("/fulltextsearch/%s.txt".formatted(docId));
            return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
     public static void main(String[] args) {
        System.out.println("Hello world");

        var doc1 = docContent("doc1");
        var doc2 = docContent("doc2");
        var doc3 = docContent("doc3");
        // System.out.println(doc1);

        // Analyzer analyzer = new SimpleAnalyzer();
        Analyzer analyzer = new NgramAnalyzer(new SimpleAnalyzer(), 3, 5);
        // var terms = analyzer.terms("""
        //     mother is here
        // """);

        // System.out.println(terms);
        // terms.stream().sorted().forEach(t -> System.out.println(t));

        InvertedIndex invertedIndex = new InvertedIndex(analyzer);
        invertedIndex.addDocument("doc1", doc1);
        invertedIndex.addDocument("doc2", doc2);
        invertedIndex.addDocument("doc3", doc3);

        System.out.println(invertedIndex.documentsOfTerm("empl"));
        System.out.println(invertedIndex.documentsOfTerm("career"));
        System.out.println(invertedIndex.documentsOfTerm("her"));

    }
}