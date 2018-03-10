// PubSub is single object for publish data to multiple subscribers
class PubSub {
    constructor () {
        this.subscribers = [];
    }

    // subscribe allows a new subscriber to listen for changes by providing
    // callback function in the parameter
    subscribe (fn) {
        this.subscribers.push(fn);
    }

    // one can publish any data to subscribers
    publish (data) {
        this.subscribers.forEach(subscriber => {
            subscriber(data);
        });
    }
}

const pubSub = new PubSub();

//===================================================

const btn = document.querySelector('#but');//for button

btn.addEventListener('click', ()=> {
pubSub.publish(window.incrementalGame.state.counter)//links with the counter in the html script
});

pubSub.subscribe(counter => {
counter ++;
console.log(window.incrementalGame.state.counter = counter);//links with the counter in the html script
document.getElementById("counter").innerText ="Skulls: " + counter ;
});