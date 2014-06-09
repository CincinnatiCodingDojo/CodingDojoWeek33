(ns dojo.week32
  (:gen-class))

(defn read-file-into-seq []
  (with-open [rdr (clojure.java.io/reader
                    "resources/words.txt")]
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

(defn guess [state word]
  (assoc state :matches (compare-words word (:password state))
               :count (inc (:count state))))

(defn init-state [wordlist num-words word-length]
  { :count 0 :words (get-possible-passwords num-words wordlist)}
)

(defn get-words-of-length [wordlist num-words word-length]
  (take num-words  (filter #(= (length-of-word %) word-length) wordlist)
   )
)
