/**
 * Created by jxuan on 16-4-8.
 */
function isPrime(value) {
    if (!isPrime.answers) {
        isPrime.answers = {};
    }

    if (isPrime.answers[value] != null) {
        return isPrime.answers[value];
    }

    var prime = value != 1;
    for (var i = 2; i < value; i++) {
        if (value % i == 0) {
            prime = false;
            break;
        }
    }
    return isPrime.answers[value] = prime;
}

function getElements(name) {
    if (!getElements.cache) {
        getElements.cache = {};
    }
    return getElements.cache[name] = getElements.cache[name] || document.getElementsByTagName(name);
}

var elems = {
    length: 0,
    add: function (elem) {
        Array.prototype.push.call(this, elem);
    },
    gather: function (id) {
        this.add(document.getElementById(id));
    }
};

function smallest(array) {
    return Math.min.apply(Math, array);
}
function largest(array) {
    return Math.max.apply(Math, array);
}

function addMethod(object, name, fn) {
    var old = object[name];
    object[name] = function () {
        if (fn.length == arguments.length) {
            return fn.apply(this, arguments);
        } else if (typeof old == 'function') {
            return old.apply(this, arguments);
        }
    }
}

(function ($) {
    $("img").on("click", function (e) {
        $(e.target).addClass("clickOn");
    })
})(jQuery);

for (var i = 0; i < length; i++) {
    (function (n) {
        alert(n);
    })(i);
}