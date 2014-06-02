(ns dojo.week32
  (:gen-class))

(defn read-file-into-seq []
  (with-open [rdr (clojure.java.io/reader
                    "/Users/be65039/Development/open/cincy-code-dojo/dojo.week32/resources/words.txt")]
    (doall (line-seq rdr))))

(defn length-of-word [word]
  (.length word)
)

(defn getwords [word-length]
  (filter #(= (length-of-word %) word-length)
    (read-file-into-seq)))

(defn get-possible-passwords [length words]
  (take length words))

(defn compare-words [word1 word2]
  (count (filter true? (map = word1 word2)))
  )
