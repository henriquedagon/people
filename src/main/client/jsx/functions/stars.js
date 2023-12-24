
export const stars = (number) => {
    if (number < 1) {
        number = 1
    }
    if (number > 5){
        number = 5
    }
    return `${'★'.repeat(number)}`
}