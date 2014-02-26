(ns cljs-shmup.core
  (:require [cljs-shmup.util :as util]))

(defn set-text [id text]
  (set!
   (.-innerText (.getElementById js/document id))
   text))

(defn set-html [id html]
  (set!
   (.-innerHTML (.getElementById js/document id))
   html))

(defn init []
  (set-html
   "game-body"
   "<div class=\"box\" id=\"player\"></div>"))

(defn update-text [dT]
  ;(set-text "text" (str dT))
  )

(let [t (atom 0)]
  (defn update-box [dT]
    (swap! t (partial + dT))
    (let [box (.getElementById js/document "player")
          style (.-style box)]
      (set! (.-left style)
            (str
             (+ 200 (* 100 (Math/cos @t)))
             "px"))
      (set! (.-top style) "500px"))))

(.getElementById js/document "box")

(let [lastFrame (atom (js/Date.now))]
  (defn update []
    (let [dT (util/time-since @lastFrame)]
      (update-text dT)
      (update-box dT))
    (swap! lastFrame js/Date.now)))

(init)
(.setInterval js/window update 33)
(set!
 (.-onmousemove js/window)
 (fn [e]
   (set-html
    "text"
    (str
     (.-clientX e)
     ", "
     (.-clientY e)))))
