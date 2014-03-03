(ns game.util)

(defn format-num
  "Makes a number look nicer for display"
  ([n] (format-num n 1))
  ([n digits]
   (let [tens (Math/pow 10 digits)
         rounded (/ (Math/round (* n tens)) tens)
         baseStr (str rounded)
         parts (split-with (partial not= \.) baseStr)]
     (apply str
            (concat
             (first parts)
             (take (inc digits) (second parts)))))))

(defn time-since [then]
  (/ (-
      (js/Date.now)
      then)
     1000))
