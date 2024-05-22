//
//  ViewController.swift
//  DiceProject
//
//  Created by Ualikhan Akberen on 23.09.2023.
//

import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var LeftDice: UIImageView!
    @IBOutlet weak var RightDice: UIImageView!
    
    let diceList: [UIImage] = [#imageLiteral(resourceName: "DiceOne"), #imageLiteral(resourceName: "DiceTwo"), #imageLiteral(resourceName: "DiceThree"), #imageLiteral(resourceName: "DiceFour"), #imageLiteral(resourceName: "DiceFive"), #imageLiteral(resourceName: "DiceSix")]
    override func viewDidLoad() {
        super.viewDidLoad()
        RightDice.image = #imageLiteral(resourceName: "DiceOne")
        LeftDice.image = #imageLiteral(resourceName: "DiceTwo")
        
    }
    @IBAction func ButtonClick(_ sender: Any) {
        let randomInt = Int.random(in: 0...5)
        LeftDice.image = diceList[randomInt]
        RightDice.image = diceList.randomElement()
    }
}


