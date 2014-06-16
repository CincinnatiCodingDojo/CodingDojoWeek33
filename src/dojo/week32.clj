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
               :remaining-guesses (dec (:remaining-guesses state))))

(defn get-words-of-length [wordlist num-words word-length]
  (take num-words (filter #(= (length-of-word %) word-length) wordlist)))

(defn init-state [wordlist num-words word-length]
  (let [words (get-words-of-length wordlist num-words word-length)]
    { :remaining-guesses 3 :words words :password (first words)}))

(defn is-winner-you [state]
  (= (count (:password state)) (:matches state)))

(defn has-exhausted-number-of-guesses [state]
  (<= (:remaining-guesses state) 0)
  )

(defn run-steps [state]
  (if (is-winner-you state)
    (println "You win!")
    (if (has-exhausted-number-of-guesses state)
      (println "You lose")
      (do
        (println "Make a guess")
        (run-steps (guess state (read-line)))))))

(defn print-passwords [state]
  (println (:words state))
  state)

(defn -main [& args]
    (run-steps (print-passwords (init-state (read-file-into-seq) 5 7))))
