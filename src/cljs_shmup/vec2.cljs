(ns cljs-shmup.vec2)

(defn len [v]
  (let [x (:x v)
        y (:y v)]
    (Math/sqrt (+ (* x x) (* y y)))))

(len {:x 0 :y 0})

(defn vec-op [op & vecs]
  (let [f (fn [k] (reduce op (map k vecs)))]
    {:x (f :x)
     :y (f :y)}))

(def add (partial vec-op +))
(def sub (partial vec-op -))

(defn scalar-mult [s v]
  {:x (* s (:x v))
   :y (* s (:y v))})

(defn unit [v]
  (let [m (len v)]
    (if (= 0 m)
      {:x 0 :y 0}
      (scalar-mult (/ 1 m) v))))
