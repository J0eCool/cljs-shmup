(ns engine.component)

(defprotocol Component
  (get-key [_])
  (update [this entity dT]))
